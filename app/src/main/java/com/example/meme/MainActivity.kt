package com.example.meme

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.meme.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    //cos you have binding gradle
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    binding.button.setOnClickListener{
        getData()
    }


    }


    //method to fetch the data
    private fun getData()
    {

        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Data is being loaded - please wait")
        progressDialog.show()
        RetroInstance.someInterface.getData().enqueue(object : Callback<responseDataClassX?> {
            override fun onResponse(
                call: Call<responseDataClassX?>,
                response: Response<responseDataClassX?>
            ) {
               //bind to the xml layouts
                binding.textView.text= response.body()?.title
                binding.textView1.text=response.body()?.author
                //imageview
                Glide.with(this@MainActivity).load(response.body()?.url).into(binding.imageView)

                progressDialog.dismiss()

            }

            override fun onFailure(call: Call<responseDataClassX?>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Failed to use Api",Toast.LENGTH_SHORT).show()
            }
        })
    }
}