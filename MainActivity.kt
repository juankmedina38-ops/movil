package com.example.primeraapp2026

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.TextField
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.input.pointer.motionEventSpy

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                Operaciones()
        }
    }
}

@Composable
fun Operaciones(){
    var num1 by remember{ mutableStateOf(value = "") }
    var num2 by remember{ mutableStateOf(value = "") }
    var resultado by remember{ mutableStateOf<Double?>(value = null) }

    var bmodifier= Modifier.fillMaxSize().height(10.dp)

        Column(modifier = Modifier.fillMaxSize().wrapContentHeight().background(Color.Gray).alpha(alpha=0.5f),
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
            Spacer(modifier = Modifier.height(height = 10.dp))
            Text(text="suma y Converciones ", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(height = 10.dp))
            TextField(value = num1, onValueChange = {num1=it}, label = {Text(text="ingrese el numero 1: ")},
                keyboardOptions = KeyboardOptions (keyboardType= KeyboardType.Number))
            Spacer(modifier = Modifier.height(height = 10.dp))
            TextField(value = num2, onValueChange = {num2=it}, label = {Text(text="ingrese el numero 2: ")},
                keyboardOptions = KeyboardOptions (keyboardType= KeyboardType.Number))

            Button(onClick = {
                val num1=num1.toDoubleOrNull()
                val num2=num2.toDoubleOrNull()
                if (num1 !=null && num2 !=null){
                    resultado=Suman(n1=num1,n2=num2)
                }
            }){Text(text ="Suma de numero")}

            Spacer(modifier =Modifier.height(height = 10.dp))

            Button(onClick = {
               val decimal=num1.toInt()
               val binario=dab(decimal)
               resultado =binario.toDoubleOrNull()


            }){Text(text = "Binario")}
            Spacer(modifier =Modifier.height(height = 10.dp))
            Button(onClick = {
                val decimal=num1.toInt()
                val terciario=dat(decimal)
                resultado =terciario.toDoubleOrNull()


            }){Text(text = "Terciario")}
            Spacer(modifier =Modifier.height(height = 10.dp))



            Spacer(modifier = Modifier.height(height = 10.dp))

            Text(text=resultado?.let{"el resultado es: $it" }?:"",fontSize=15.sp)


        }
}

fun Suman(n1: Double, n2:Double): Double{
    return n1+n2
}
fun dab(decimal:Int):String{
    return decimal.toString(radix = 2)
}

fun dat(decimal:Int):String{
    return decimal.toString(radix = 3)
}