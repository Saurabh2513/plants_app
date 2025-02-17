package com.example.shopy

import PlantAdapter
import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shopy.databinding.ActivityMainBinding
import com.example.shopy.model.Plant
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var plantAdapter: PlantAdapter
    private lateinit var plantList: List<Plant>

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Load plants from JSON
        plantList = loadPlantsFromJson(this)

        plantAdapter = PlantAdapter(this, plantList)
        recyclerView.adapter = plantAdapter

    }

    private fun loadPlantsFromJson(context: Context): List<Plant> {
        val plantList = mutableListOf<Plant>()
        try {
            // Open the JSON file from the assets folder
            val inputStream = context.assets.open("image.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            // Convert the byte array to a JSON string
            val jsonString = String(buffer, Charsets.UTF_8)

            // Parse the JSON array
            val jsonArray = JSONArray(jsonString)

            // Iterate through the JSON array
            for (i in 0 until jsonArray.length()) {
                val plantObject = jsonArray.getJSONObject(i)
                val image = plantObject.getString("image")
                val title = plantObject.getString("title")
                plantList.add(Plant(image, title))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return plantList
    }
}

