import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shopy.R
import com.example.shopy.model.Plant

class PlantAdapter(
    private val context: Context,
    private val plantList: List<Plant>
) : RecyclerView.Adapter<PlantAdapter.PlantViewHolder>() {

    // ViewHolder for the Plant item
    class PlantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        // Inflate the item layout
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_plant, parent, false)
        return PlantViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        // Bind data to the views
        val plant = plantList[position]
        holder.imageView.setImageResource(
            getDrawableResourceId(context, plant.image)
        )
        holder.titleTextView.text = plant.title
    }

    override fun getItemCount(): Int {
        return plantList.size
    }

    private fun getDrawableResourceId(context: Context, imageName: String): Int {
        return context.resources.getIdentifier(imageName, "drawable", context.packageName)
    }
}