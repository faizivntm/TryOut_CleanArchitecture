package com.salugan.cobakeluar.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.salugan.cobakeluar.R
import com.salugan.cobakeluar.core.domain.models.HasilModel
import com.salugan.cobakeluar.databinding.ItemCardBinding

class HistoryAdapter(private val hasilHistory: ArrayList<HasilModel>) :
    RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun getItemCount(): Int = hasilHistory.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(hasilHistory[position])
    }


    class ViewHolder(private val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hasilModel: HasilModel) {
            binding.benar.text =
                String.format(itemView.context.getString(R.string.benar), hasilModel.benar)
            binding.salah.text =
                String.format(itemView.context.getString(R.string.salah), hasilModel.salah)
            binding.kosong.text =
                String.format(itemView.context.getString(R.string.kosong), hasilModel.kosong)
            binding.tanggal.text = hasilModel.tanggal
            binding.waktu.text = hasilModel.waktu
            binding.nilaiData.text = hasilModel.nilai
        }
    }
}