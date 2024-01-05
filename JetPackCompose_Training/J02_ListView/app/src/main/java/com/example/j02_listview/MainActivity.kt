package com.example.j02_listview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.j02_listview.ui.theme.J02_ListViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            J02_ListViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    preview()
                }
            }
        }
    }
}

@Preview
@Composable
fun preview(){
    var gerrit_name by remember {
        mutableStateOf("Enter Gerrit Name")
    }
    var gerrit_link by remember {
        mutableStateOf("Enter Gerrit Link")
    }

    var gerrit_description by remember { mutableStateOf("Enter Gerrrit Description here") }
    Column {
        Text(text = "Hello World")

        custom_textfield(heading = "Gerrit Name", mutable_value = gerrit_name)
    }

}

@Composable
fun custom_textfield(heading : String,mutable_value : MutableState<String>){
    TextField(value = mutable_value.value,
        onValueChange = {mutable_value.value = it},
        label = { Text(text = heading)})
}