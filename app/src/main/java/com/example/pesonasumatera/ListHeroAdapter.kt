import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pesonasumatera.DetailPages
import com.example.pesonasumatera.Pesona
import com.example.pesonasumatera.R


class ListHeroAdapter(private val listPesona: ArrayList<Pesona>) :
    RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_pesona, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listPesona[position]
        Glide.with(holder.itemView.context)
            .load(photo).into(holder.imgPhoto)
        holder.tvName.text = name
        holder.tvDescription.text = description


        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailPages::class.java)
            intentDetail.putExtra("key_pesona", listPesona[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }

    }

    override fun getItemCount(): Int = listPesona.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }
}