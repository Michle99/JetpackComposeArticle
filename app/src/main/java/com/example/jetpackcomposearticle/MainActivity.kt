package com.example.jetpackcomposearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposearticle.ui.theme.JetpackComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    JetPackComposeArticleApp()

                }
            }
        }
    }
}



@Composable
fun JetPackComposeArticleApp() {
    JetPackComposeArticleTextColumns(
        title = stringResource(R.string.jetpack_title),
        firstParagraph = stringResource(R.string.article_first_parag),
        secondParagraph = stringResource(R.string.article_second_parag),
        imagePainter = painterResource(id = R.drawable.bg_compose_background)
    )
}

@Composable
fun JetPackComposeArticleTextColumns(
    title: String,
    firstParagraph: String,
    secondParagraph: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier,
    ) {
        Column(modifier = modifier) {
            Image(painter = imagePainter, contentDescription = null)
            Text(
                text = title,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 16.dp)
            )
            Text(
                text = firstParagraph,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
            )
            Text(
                text = secondParagraph,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 16.dp)
            )
        }
}

@Preview(showBackground = true)
@Composable
fun JetPackComposeArticleImagePreview() {
    JetpackComposeArticleTheme {
        JetPackComposeArticleApp()

    }
}