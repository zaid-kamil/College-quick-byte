package haw.bmaajp.groceriesapp.presentation.screen.onboarding

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import haw.bmaajp.groceriesapp.R
import haw.bmaajp.groceriesapp.navigation.graph.Graph
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_12dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_16dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_40dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_68dp
import haw.bmaajp.groceriesapp.ui.theme.DIMENS_90dp
import haw.bmaajp.groceriesapp.ui.theme.GilroyFontFamily
import haw.bmaajp.groceriesapp.ui.theme.GrayTextColor
import haw.bmaajp.groceriesapp.ui.theme.Green
import haw.bmaajp.groceriesapp.ui.theme.TEXT_SIZE_16sp
import haw.bmaajp.groceriesapp.ui.theme.TEXT_SIZE_18sp
import haw.bmaajp.groceriesapp.ui.theme.TEXT_SIZE_49sp

@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onBoardingViewModel: OnBoardingViewModel = hiltViewModel(),
) {
    OnBoarding(
        modifier = modifier.fillMaxSize(),
        onComplete = {
            navController.popBackStack()
            navController.navigate(Graph.MAIN)
            onBoardingViewModel.saveOnBoardingState(isCompleted = true)
        }
    )
}

@Composable
fun OnBoarding(
    modifier: Modifier = Modifier,
    onComplete: () -> Unit,
) {
    val prefs = LocalContext.current.getSharedPreferences("app", Context.MODE_PRIVATE)
    var inputEmail by remember {
        mutableStateOf("")
    }
    var inputPassword by remember {
        mutableStateOf("")
    }
    var inputRoll by remember {
        mutableStateOf("")
    }
    var inputCourse by remember {
        mutableStateOf("")
    }
    var inputSemester by remember {
        mutableStateOf("")
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        var showLogin by remember {
            mutableStateOf(false)
        }
        var showSignUp by remember {
            mutableStateOf(false)
        }
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.img_onboarding),
            contentDescription = stringResource(R.string.image_on_boarding),
            contentScale = ContentScale.Crop
        )
        Surface(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = DIMENS_90dp),
            color = Color.Transparent
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.welcome_to_store),
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = TEXT_SIZE_49sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = stringResource(R.string.desc_welcome),
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = TEXT_SIZE_16sp,
                    color = GrayTextColor,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(DIMENS_40dp))
                Button(
                    onClick = {
                        showLogin = true
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(height = DIMENS_68dp)
                        .padding(start = DIMENS_16dp, end = DIMENS_16dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Green),
                    shape = RoundedCornerShape(DIMENS_12dp),
                ) {
                    Text(
                        text = stringResource(R.string.get_started),
                        fontFamily = GilroyFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = TEXT_SIZE_18sp,
                        color = Color.White
                    )
                }
            }
            if (showLogin) {
                // Login screen box with college roll no and password
                Box {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(DIMENS_16dp),
                        color = MaterialTheme.colors.surface,
                        shape = RoundedCornerShape(DIMENS_12dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(DIMENS_16dp)
                        ) {
                            Text(
                                text = "Login",
                                fontFamily = GilroyFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = TEXT_SIZE_18sp,
                                color = GrayTextColor,
                                textAlign = TextAlign.Center,
                            )
                            Spacer(modifier = Modifier.height(DIMENS_16dp))
                            TextField(
                                value = inputEmail,
                                onValueChange = {
                                    inputEmail = it
                                },
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = {
                                    Text(
                                        text = "email",
                                        fontFamily = GilroyFontFamily,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = TEXT_SIZE_16sp,
                                        color = GrayTextColor
                                    )
                                },
                                textStyle = MaterialTheme.typography.body1,
                                singleLine = true
                            )
                            Spacer(modifier = Modifier.height(DIMENS_16dp))
                            TextField(
                                value = inputPassword,
                                onValueChange = {
                                    inputPassword = it
                                },
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = {
                                    Text(
                                        text = "password",
                                        fontFamily = GilroyFontFamily,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = TEXT_SIZE_16sp,
                                        color = GrayTextColor
                                    )
                                },
                                textStyle = MaterialTheme.typography.body1,
                                singleLine = true,
                                visualTransformation = PasswordVisualTransformation()
                            )
                            Spacer(modifier = Modifier.height(DIMENS_16dp))
                            Button(
                                onClick = {
                                    showLogin = false
                                    onComplete()
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(height = DIMENS_68dp),
                                colors = ButtonDefaults.buttonColors(backgroundColor = Green),
                                shape = RoundedCornerShape(DIMENS_12dp),
                            ) {
                                Text(
                                    text = "Login",
                                    fontFamily = GilroyFontFamily,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = TEXT_SIZE_18sp,
                                    color = Color.White
                                )
                            }
                            Spacer(modifier = Modifier.height(DIMENS_16dp))
                            TextButton(
                                onClick = {
                                    showLogin = false
                                    showSignUp = true

                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "Don't have an account? Sign up",
                                    fontFamily = GilroyFontFamily,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = TEXT_SIZE_16sp,
                                    color = Green
                                )
                            }
                        }

                    }
                }
            }
            if (showSignUp) {
                // Sign up screen
                Box {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(DIMENS_16dp),
                        color = MaterialTheme.colors.surface,
                        shape = RoundedCornerShape(DIMENS_12dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(DIMENS_16dp)
                        ) {
                            Text(
                                text = "Sign Up",
                                fontFamily = GilroyFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = TEXT_SIZE_18sp,
                                color = GrayTextColor,
                                textAlign = TextAlign.Center,
                            )
                            Spacer(modifier = Modifier.height(DIMENS_16dp))
                            TextField(
                                value = inputEmail,
                                onValueChange = {
                                    inputEmail = it
                                },
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = {
                                    Text(
                                        text = "email",
                                        fontFamily = GilroyFontFamily,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = TEXT_SIZE_16sp,
                                        color = GrayTextColor
                                    )
                                },
                                textStyle = MaterialTheme.typography.body1,
                                singleLine = true
                            )
                            Spacer(modifier = Modifier.height(DIMENS_16dp))
                            TextField(
                                value = inputPassword,
                                onValueChange = {
                                    inputPassword = it
                                },
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = {
                                    Text(
                                        text = "password",
                                        fontFamily = GilroyFontFamily,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = TEXT_SIZE_16sp,
                                        color = GrayTextColor
                                    )
                                },
                                textStyle = MaterialTheme.typography.body1,
                                singleLine = true,
                                visualTransformation = PasswordVisualTransformation()
                            )
                            Spacer(modifier = Modifier.height(DIMENS_16dp))
                            // roll no input
                            TextField(
                                value = inputRoll,
                                onValueChange = {
                                    inputRoll = it
                                },
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = {
                                    Text(
                                        text = "college roll no",
                                        fontFamily = GilroyFontFamily,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = TEXT_SIZE_16sp,
                                        color = GrayTextColor
                                    )
                                },
                                textStyle = MaterialTheme.typography.body1,
                                singleLine = true
                            )
                            // course input
                            TextField(
                                value = inputCourse,
                                onValueChange = {
                                    inputCourse = it
                                },
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = {
                                    Text(
                                        text = "course",
                                        fontFamily = GilroyFontFamily,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = TEXT_SIZE_16sp,
                                        color = GrayTextColor
                                    )
                                },
                                textStyle = MaterialTheme.typography.body1,
                                singleLine = true
                            )
                            // semester
                            TextField(
                                value = inputSemester,
                                onValueChange = {
                                    inputSemester = it
                                },
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = {
                                    Text(
                                        text = "semester",
                                        fontFamily = GilroyFontFamily,
                                        fontWeight = FontWeight.Medium,
                                        fontSize = TEXT_SIZE_16sp,
                                        color = GrayTextColor
                                    )
                                },
                                textStyle = MaterialTheme.typography.body1,
                                singleLine = true
                            )
                            // submit
                            Button(
                                onClick = {
                                    showSignUp = false
                                    onComplete()
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(height = DIMENS_68dp),
                                colors = ButtonDefaults.buttonColors(backgroundColor = Green),
                                shape = RoundedCornerShape(DIMENS_12dp),
                            ) {
                                Text(
                                    text = "Sign Up",
                                    fontFamily = GilroyFontFamily,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = TEXT_SIZE_18sp,
                                    color = Color.White
                                )
                            }
                            Spacer(modifier = Modifier.height(DIMENS_16dp))
                            TextButton(
                                onClick = {
                                    showSignUp = false
                                    showLogin = true
                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "Already have an account? Login",
                                    fontFamily = GilroyFontFamily,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = TEXT_SIZE_16sp,
                                    color = Green
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun OnBoardingPreview() {
    OnBoarding(onComplete = {})
}