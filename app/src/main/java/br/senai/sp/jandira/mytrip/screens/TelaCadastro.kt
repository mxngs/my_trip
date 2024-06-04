package br.senai.sp.jandira.mytrip.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraEnhance
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PhoneIphone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.mytrip.R
import br.senai.sp.jandira.mytrip.model.Cadastro
import br.senai.sp.jandira.mytrip.repository.CadastroRepository

@SuppressLint("SuspiciousIndentation")
@Composable
fun NovaConta(controleDeNavegacao: NavHostController) {

    var userNameState = remember {
        mutableStateOf("")
    }

    var senhaState = remember {
        mutableStateOf("")
    }

    var telefoneState = remember {
        mutableStateOf("")
    }

    var emailState = remember {
        mutableStateOf("")
    }

    var idadeState = remember {
        mutableStateOf(false)
    }
    var cadastroState = remember {
        mutableStateOf("Usuário criado com sucesso!!")
    }
    val meuContexto = LocalContext.current

    var isErrorState = remember {
        mutableStateOf(false)
    }

    var messageErrorState = remember {
        mutableStateOf("")
    }

    val cr = CadastroRepository(LocalContext.current)

    Column(
        modifier = Modifier.height(800.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            horizontalArrangement = Arrangement.End
        )
        {
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .background(
                        Color(0xFFCF06F0),
                        shape = RoundedCornerShape(bottomStart = 30.dp),
                    )
                    .width(150.dp),
            ) {

            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.sing_up),
                color = Color(0xFFCF06F0),
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(id = R.string.new_account),
                color = Color(0xFFA09C9C)
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Card(
            modifier = Modifier
                .size(height = 100.dp, width = 100.dp)
                .align(alignment = Alignment.CenterHorizontally),
            elevation = CardDefaults.cardElevation(10.dp),
            shape = CircleShape,
            border = BorderStroke(1.dp, Color.Magenta),
        ) {
            Icon(
                modifier = Modifier
                    .fillMaxSize(),
                imageVector = Icons.Filled.Person,
                contentDescription = "",
                tint = Color(0xFFCF06F0)
            )
        }
        Icon(
            imageVector = Icons.Filled.CameraEnhance,
            contentDescription = "Icone foto",
            modifier = Modifier
                .padding(start = 230.dp)
                .offset(y = -30.dp)
                .size(25.dp),
            tint = Color(0xFFCF06F0)
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
                .padding(end = 20.dp),
            value = userNameState.value,
            onValueChange = {
                userNameState.value = it
            },
            shape = RoundedCornerShape(15.dp),
            label = {
                Text(text = stringResource(id = R.string.username))
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                unfocusedBorderColor = Color(0xFFCF06F0),
                focusedBorderColor = Color(0xFFCF06F0)
            ),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words
            ),

            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "",
                    tint = Color(0xFFCF06F0)
                )
            }

        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
                .padding(end = 20.dp),
            value = telefoneState.value,
            onValueChange = {
              telefoneState.value = it
            },
            shape = RoundedCornerShape(15.dp),
            label = {
                Text(text = stringResource(id = R.string.phone))
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                unfocusedBorderColor = Color(0xFFCF06F0),
                focusedBorderColor = Color(0xFFCF06F0)
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),

            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.PhoneIphone,
                    contentDescription = "",
                    tint = Color(0xFFCF06F0)
                )
            }

        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
                .padding(end = 20.dp),
            value = emailState.value,
            onValueChange = {
                emailState.value =it
            },
            shape = RoundedCornerShape(15.dp),
            label = {
                Text(text = stringResource(id = R.string.email))
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                unfocusedBorderColor = Color(0xFFCF06F0),
                focusedBorderColor = Color(0xFFCF06F0)
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "",
                    tint = Color(0xFFCF06F0)
                )
            }

        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
                .padding(end = 20.dp),
            value = senhaState.value,
            onValueChange = {
                senhaState.value = it
            },
            shape = RoundedCornerShape(15.dp),
            label = {
                Text(text =  stringResource(id = R.string.password))
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                unfocusedBorderColor = Color(0xFFCF06F0),
                focusedBorderColor = Color(0xFFCF06F0)
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                capitalization = KeyboardCapitalization.Characters,
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "",
                    tint = Color(0xFFCF06F0)
                )
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp)
                .align(Alignment.Start),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Checkbox(checked = idadeState.value,
                onCheckedChange = {
                    idadeState.value = it
                }
            )
            Text(text = stringResource(id = R.string.over_eighteen))
        }
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        Button(
            onClick ={
                val cadastro = Cadastro(
                    username = userNameState.value,
                    telefone = telefoneState.value,
                    email = emailState.value,
                    senha = senhaState.value,
                    maiorDeIdade = idadeState.value
                )
                     if (userNameState.value != "" || telefoneState.value != "" ||emailState.value != "" || senhaState.value != "" ){
                         Toast.makeText(
                             meuContexto,
                             cadastroState.value,
                             Toast.LENGTH_LONG
                         ).show()
                         cr.salvar(cadastro = cadastro)
                         controleDeNavegacao.navigate("login")
                     }else{
                             isErrorState.value = true
                             messageErrorState.value = "Preencha todos os campos!!"
                     }
            },
            colors = ButtonDefaults
                .buttonColors(Color(0xFFCF06F0)),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(start = 20.dp)
                .padding(end = 20.dp),
            shape = RoundedCornerShape(15.dp),
        ) {
            Text(
                text = stringResource(id = R.string.create_account),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = messageErrorState.value,
                color = Color.Red
            )
        }
    }
}
