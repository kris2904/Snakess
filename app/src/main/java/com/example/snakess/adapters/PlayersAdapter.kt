package com.example.snakess.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.snakess.base.ABaseAdapter
import com.example.snakess.domain.repositories.models.rest.GameResult
import com.example.snakess.adapters.PlayerView.ITypeLobbyView
import com.example.snakess.adapters.PlayerView.TypeLobbyView


class PlayersAdapter: ABaseAdapter<GameResult, RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_LOBBY = 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view: View =
            TypeLobbyView(parent.context)
        view.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        return object : RecyclerView.ViewHolder(view) {}
    }

   /* override fun getItemViewType(position: Int): Int {
        return TYPE_LOBBY
    }*/

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = holder.itemView
        if (view is ITypeLobbyView)
            view.bind(data[position])
    }

    //:RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /*var mPlayersList:ArrayList<GameResult> = ArrayList()
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
    }*/
}