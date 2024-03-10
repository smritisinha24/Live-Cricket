package com.example.livecricketscore.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.livecricketscore.Model.Data
import com.example.livecricketscore.databinding.ItemLayoutBinding

class CricketAdapter(private  val items : ArrayList<Data>)  : RecyclerView.Adapter<CricketAdapter.CricketViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CricketViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutBinding.inflate(inflater,parent,false)

        return CricketViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CricketViewHolder, position: Int) {

        val curretitem = items[position]
        holder.bind(curretitem)

    }

    inner  class  CricketViewHolder(private  val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Data) {
//            binding.team2TvName.text = item.teamInfo.get(0).name
            binding.apply {
                team1Name.text = item.teamInfo[0].name // Update team1_name text
                team2TvName.text = item.teamInfo[1].name
                typeTv.text = item.matchType.toUpperCase()
                venueTv.text = item.venue
                statusTv.text = item.status

                if (item.teamInfo.size == 2) {
                    Glide.with(binding.root.context).load(item.teamInfo.get(0).img)
                        .into(binding.team1Iv)
                }


                binding.typeTv.text = item.matchType.toUpperCase()
                binding.venueTv.text = item.venue
                binding.statusTv.text = item.status

                if (item.teamInfo.size == 2) {

                    Glide.with(binding.root.context).load(item.teamInfo[0].img).into(team1Iv)
                    Glide.with(binding.root.context).load(item.teamInfo[1].img).into(team2Iv)

//                    Glide.with(binding.root.context).load(item.teamInfo.get(1).img)
//                        .into(binding.team2Iv)
                }





                if (item.score.size == 1) {

                    binding.scroeT1Tv.text = "${item.score.get(0).r}" + "/${item.score.get(0).w}"
                    binding.overT1Tv.text = "${item.score.get(0).o}Overs"
                }

                if (item.score.size == 2) {

                    binding.scroeT1Tv.text = "${item.score.get(0).r}" + "/${item.score.get(0).w}"
                    binding.overT1Tv.text = "${item.score.get(0).o}Overs"



                    binding.scoreT2Tv.text = "${item.score.get(1).r}" + "/${item.score.get(1).w}"
                    binding.overT2Tv.text = "${item.score.get(1).o}Overs"
                }

            }
        }
    }
}