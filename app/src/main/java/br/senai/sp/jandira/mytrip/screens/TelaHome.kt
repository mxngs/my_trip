package br.senai.sp.jandira.mytrip.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.mytrip.R
import br.senai.sp.jandira.mytrip.repository.CategoriaRepository
import br.senai.sp.jandira.mytrip.repository.ViagemRepository
import br.senai.sp.jandira.mytrip.simplificarData

@Composable
fun HomePage(controleDeNavegacao: NavHostController) {

    val viagens = ViagemRepository().listarTodasAsViagens(LocalContext.current)
    val categorias = CategoriaRepository().listarTodasCategorias(LocalContext.current)

    var pesquisaState = remember {
        mutableStateOf("")
    }

    Scaffold (
        floatingActionButton = {
            FloatingActionButton(
                onClick = {

            },
                shape = CircleShape,
                containerColor = Color(0xffCF06F0)
            )
            {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xffF6F6F6))

            ) {
                Box(
                    modifier = Modifier.fillMaxWidth()

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.franca),
                        contentDescription = "Paris"

                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, start = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {
                        Column(
                            horizontalAlignment = Alignment.Start,
                            modifier = Modifier.offset(y = 138.dp)

                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.LocationOn,
                                    contentDescription = "",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .size(20.dp)
                                )
                                Text(
                                    text = stringResource(id = R.string.locale),
                                    color = Color.White
                                )
                            }

                            Text(
                                text = stringResource(id = R.string.title),
                                color = Color.White,
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 24.sp
                            )
                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,

                            modifier = Modifier
                                .padding(15.dp, 20.dp)

                        ) {

                            Card(
                                modifier = Modifier
                                    .size(65.dp, 65.dp),
                                shape = CircleShape,
                            ) {

                                Image(
                                    painter = painterResource(id = R.drawable.mulher),
                                    contentDescription = "Foto de perfil",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.size(65.dp)
                                )
                            }
                            Text(
                                text = "Murilo Carolino",
                                fontSize = 12.sp,
                                color = Color.White
                            )
                        }
                    }

                }
                Column(
                    modifier = Modifier.padding(15.dp, 10.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = stringResource(id = R.string.categories),
                        color = Color(0xff565454),
                        fontWeight = FontWeight(400)
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    LazyRow() {
                        items(categorias) {
                            Card(
                                modifier = Modifier
                                    .size(120.dp, 75.dp)
                                    .padding(end = 8.dp)
                                    .clickable {},
                                colors = CardDefaults
                                    .cardColors(containerColor = Color(0xffCF06F0)),
                                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center,
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    Image(
                                        painter = if (it.imagem == null) painterResource(id = R.drawable.no_image) else it.imagem!!,
                                        contentDescription = ""
                                    )

                                    Text(
                                        text = it.categoria,
                                        color = Color.White,
                                        fontSize = 14.sp
                                    )

                                }

                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(value = pesquisaState.value,
                    onValueChange = {
                        pesquisaState.value = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        focusedBorderColor = Color.White
                    ),
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Words
                    ),
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.search),
                            color = Color(0xffA09C9C)
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = { }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Botão buscar",
                                tint = Color(0xffA09C9C)
                            )
                        }
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(id = R.string.past_trips),
                    color = Color(0xff565454),
                    fontWeight = FontWeight(400),
                    modifier = Modifier.padding(8.dp)
                )

                LazyColumn() {
                    items(viagens) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Card(
                                modifier = Modifier
                                    .width(350.dp)
                                    .padding(vertical = 8.dp),
                                colors = CardDefaults.cardColors(Color.White),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                shape = RoundedCornerShape(8.dp),
                                border = BorderStroke(1.dp, color = Color.White)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Card(
                                        modifier = Modifier
                                            .height(106.dp)
                                            .width(330.dp)
                                    ) {
                                        Surface {
                                            Image(
                                                painter = if (it.imagem == null) painterResource(id = R.drawable.no_image) else it.imagem!!,
                                                contentDescription = "",
                                                contentScale = ContentScale.Crop,
                                                modifier = Modifier.fillMaxSize()

                                            )
                                        }

                                    }
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Column(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalAlignment = Alignment.Start
                                    ) {
                                        Text(
                                            text = "${it.destino}, ${it.dataChegada.year}",
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight(400),
                                            color = Color(0xffCF06F0)
                                        )

                                        Text(
                                            text = it.descricao,
                                            fontSize = 12.sp,
                                            color = Color(0xffA09C9C),
                                            lineHeight = 15.sp
                                        )

                                    }
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.End
                                    ) {
                                        Text(
                                            text = "${simplificarData(it.dataChegada)} - ${
                                                simplificarData(
                                                    it.dataPartida
                                                )
                                            }",
                                            color = Color(0xffCF06F0),
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight(400)
                                        )
                                    }

                                }
                            }


                        }


                    }

                }


            }
        }
    }
    }



