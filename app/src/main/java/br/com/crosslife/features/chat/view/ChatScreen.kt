package br.com.crosslife.features.chat.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.crosslife.R
import br.com.crosslife.extensions.capitalize
import br.com.crosslife.ui.theme.Space

@Composable
fun NavController.ChatScreen() {
    Column(
        Modifier
            .fillMaxHeight()
            .padding(horizontal = Space.BORDER)
            .padding(bottom = Space.BOTTOM_NAVIGATION)
            .verticalScroll(rememberScrollState())
    ) {
        ChatHeader()
        ChatBody()
    }
}

@Composable
fun ChatHeader() {
    Text(
        text = stringResource(id = R.string.menu_item_chat).capitalize(),
        style = MaterialTheme.typography.h1,
        modifier = Modifier.padding(top = Space.XXS)
    )
    Text(
        text = stringResource(id = R.string.chat_description).capitalize(),
        style = MaterialTheme.typography.body1,
        modifier = Modifier.padding(top = Space.XXS)
    )
}

@Composable
fun ChatBody() {
    InstructorCard(Modifier.padding(top = Space.XM, bottom = Space.XXXS))
    ChatDivider()
    InstructorCard(Modifier.padding(top = Space.XXXS, bottom = Space.XXXS))
}

@Composable
fun InstructorCard(modifier: Modifier) {
    Card(
        modifier
            .fillMaxWidth()
            .height(120.dp),
        backgroundColor = MaterialTheme.colors.surface,
        shape = MaterialTheme.shapes.large,
    ) {
        Row() {

        }
    }
}

@Composable
fun ChatDivider() {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Box(
            Modifier
                .background(MaterialTheme.colors.surface)
                .weight(1F)
                .height(1.dp)
        )
        Text(
            text = stringResource(id = R.string.or).uppercase(),
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .padding(horizontal = Space.XS)
                .background(MaterialTheme.colors.background)
        )
        Box(
            Modifier
                .background(MaterialTheme.colors.surface)
                .weight(1F)
                .height(1.dp)
        )
    }
}
