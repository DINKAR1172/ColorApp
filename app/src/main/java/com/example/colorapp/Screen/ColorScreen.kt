package com.example.colorapp.Screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.colorapp.Model.Colours
import com.example.colorapp.R
import com.example.colorapp.Viewmodel.ColorViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun ColorScreen(NviewModel: ColorViewModel){
Scaffold(
    topBar = { TopAppBar(title = { Text(text = "Color App", color = Color.White)}, backgroundColor = colorResource(
        id = R.color.BarColor
    ), actions = { Button(onClick = {}, shape = CircleShape, colors = ButtonDefaults.buttonColors(
        colorResource(id =R.color.BarButton))) {
        Text(text = "12", fontSize = 20.sp)
        Spacer(modifier = Modifier.width(2.dp))
        Icon(painter = painterResource(id = R.drawable.refresh), contentDescription =null, tint = colorResource(
            id = R.color.BarColor
        ))
    }})}, floatingActionButton = { Button(onClick = {NviewModel.Insert(Colours(Colorid ="#AABBFF", TimeStamp =1683798291864))}, colors = ButtonDefaults.buttonColors(
        colorResource(id = R.color.BarButton)), shape = CircleShape) {
        Text(text = "Add Color", color =colorResource(id = R.color.BarColor) )
        Spacer(modifier = Modifier.width(2.dp))
        Icon(imageVector =Icons.Outlined.Add, contentDescription = null, tint = colorResource(id = R.color.BarColor))
    }}
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(it)){
        val data=NviewModel.getAllData().collectAsState(initial = listOf())
      LazyVerticalGrid(columns =GridCells.Fixed(2)){
      items(data.value){cc->
LazyItem(cc)
    }
      }
    }
}

    val databaseitem = listOf(Colours(1,"#FFAABB",1683908084000),Colours(2,"#D7415F",1683389684000),Colours(3,"#E4AAFF", 1683044084000),Colours(4,"#7E6ACF",1699287284000),Colours(5,"#7FC3E9", 1683735284000),Colours(6,"#ECA02F",1683648884000),Colours(7,"#DEAE82",1683130484000))
    databaseitem.forEach {data->
        NviewModel.Insert(data)
    }
}
@Composable
fun LazyItem(data:Colours){
    var date by remember { mutableStateOf("") }
    date= formatTimestamp(data)
    Box(modifier = Modifier
        .size(200.dp)
        .background(
            color = Color(android.graphics.Color.parseColor(data.Colorid)),
            RoundedCornerShape(2.dp)
        )){
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween){
      Row(modifier = Modifier.fillMaxWidth(.5f), horizontalArrangement = Arrangement.Start){
          Column {
              Text(text = "${data.Colorid}", fontSize = 18.sp, color = Color.White)
              Divider(color = Color.White)
          }

       }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End){
                Column {
                       Text(text = "Created at", fontSize = 18.sp,color=Color.White)
                       Text(text = "$date", fontSize = 18.sp,color=Color.White)
                   } 

            }
        }

    }
}
fun formatTimestamp(data: Colours): String {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val date = Date(data.TimeStamp)
    return dateFormat.format(date)
}
