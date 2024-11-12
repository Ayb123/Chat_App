package com.example.chatapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth

class UserAdapter(val context: Context, val userList: ArrayList<User>): RecyclerView.Adapter<UserAdapter.UserViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        // Création de la vue de l'élément de la liste des utilisateurs
        val view: View = LayoutInflater.from(context).inflate(R.layout.user_layout, parent, false)
        return UserViewHolder(view)

    }

    override fun getItemCount(): Int {
        // Retourne le nombre d'utilisateurs dans la liste
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        // Lie les données de l'utilisateur à l'élément de la liste
        val currentUser = userList[position]

        holder.textName.text = currentUser.name

        // quand on clique on doit ouvrir :

        holder.itemView.setOnClickListener{
            val intent = Intent(context, ChatActivity::class.java)
            // Ouvrir l'activité de chat avec l'utilisateur sélectionné
            intent.putExtra("name", currentUser.name)
            intent.putExtra("uid", currentUser.uid)

            context.startActivity(intent)
        }

    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // ViewHolder pour l'élément de la liste des utilisateurs
        val textName = itemView.findViewById<TextView>(R.id.txt_name)

    }



}