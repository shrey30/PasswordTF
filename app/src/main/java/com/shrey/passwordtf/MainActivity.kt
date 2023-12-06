package com.shrey.passwordtf

import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.shrey.passwordtf.ui.theme.PasswordTFTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PasswordTFTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PasswordBox()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordBox(){
    Surface(modifier = Modifier.fillMaxSize(),
        color = Color(0xFFa2d2ff)) {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            var password by rememberSaveable {
                mutableStateOf("")
            }
            var passwordvisibility by remember {
                mutableStateOf(false)
            }
            val Icon = if (passwordvisibility)
            {
                painterResource(id = R.drawable.baseline_visibility_24)
            }
            else
            {
                painterResource(id = R.drawable.baseline_visibility_off_24)
            }
            OutlinedTextField(value = password , onValueChange = {
                password = it
            },
                textStyle = androidx.compose.ui.text.TextStyle(color = Color(0xFF000000)),
                label = { Text(text = "Password",
                    color = Color(0xFF023e8a)
                )},
                placeholder = { Text(text = "Enter Password",
                    color = Color(0xFF023e8a))},
                trailingIcon = {
                    IconButton(onClick = { passwordvisibility = !passwordvisibility }) {
                        Icon(painter = Icon,
                            contentDescription ="Visibility On",
                            tint = Color.Unspecified
                        )
                    }
                },
                visualTransformation = if (passwordvisibility) VisualTransformation.None
                else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF023e8a),
                    unfocusedBorderColor = Color(0xFF023e8a),
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PasswordTFTheme {
       PasswordBox()
    }
}