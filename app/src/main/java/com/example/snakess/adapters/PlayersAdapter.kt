package com.example.snakess.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.snakess.R
import com.example.snakess.domain.repositories.models.rest.GameResult


class PlayersAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var mPlayersList:ArrayList<GameResult> = ArrayList()
    //отрисовка списка
    fun setupPlayers(gameResulList:ArrayList<GameResult>){
        mPlayersList.clear()
        mPlayersList.addAll(gameResulList)
        //говорим,что данные изменились, и их нужно отрисовать заного
        notifyDataSetChanged()
    }
    //создается класс View
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PlayersViewHolder(itemView =
        LayoutInflater.from(parent.context)
            .inflate(R.layout.cell_player,parent,false))

    }

    override fun getItemCount(): Int {
        return  mPlayersList.count()
    }
//Заполняем созданный класс
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is PlayersViewHolder){
            holder.bind(gameResult = mPlayersList[position])
        }
    }
    //класс который отображает ячейку
    class PlayersViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        private var mTxtLogin: TextView=itemView.findViewById(R.id.txt_loginn_player)
      //отрисовка модели и тд
        fun bind(gameResult:GameResult){
          mTxtLogin.text=gameResult.login
      }
    }
}