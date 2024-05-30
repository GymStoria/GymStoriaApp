import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.afebrii.gymstoriaapp.R

@Composable
fun MembershipScreen() {
    val members = listOf(
        Member("John Doe", "Umum", "TJG234923264", 4.0f, "6 bulan", "CLASSIC", R.drawable.the_jade),
        Member("Jane Smith", "Umum", "TJG234923264", 3.5f, "12 bulan", "CLASSIC", R.drawable.timor_gym),
        Member("Alice Johnson", "Umum", "TJG234923264", 4.5f, "3 bulan", "CLASSIC", R.drawable.viky_gym)
    )

    Column {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp),
                contentScale = ContentScale.Crop
            )
            Icon(
                imageVector = Icons.Filled.ArrowBackIosNew,
                contentDescription = "Back",
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(start = 20.dp, end = 48.dp, top = 33.dp)
            )
            Text(
                text = "KEANGGOTAAN",
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
        members.forEach { member ->
            ConstraintLayout(
                Modifier
                    .fillMaxWidth()
                    .padding(8.5.dp)
                    .height(120.dp)
                    .shadow(20.dp, shape = RoundedCornerShape(16.dp))
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp)
                    )
            ) {
                val (image, name, tipe_member, nomor_kartu, masaAktif, status) = createRefs()

                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .constrainAs(image) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            bottom.linkTo(parent.bottom)
                        }
                ) {
                    Image(
                        painter = painterResource(id = member.imageRes),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                            .padding(start = 8.dp),
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .absoluteOffset(y = 13.dp)
                            .padding(start = 11.dp, top = 8.5.dp)
                            .background(
                                color = Color(0xFF800080),
                                shape = RoundedCornerShape(8.dp)
                            )
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = null,
                            modifier = Modifier
                                .size(17.dp)
                                .padding(start = 2.dp),
                            tint = Color.Yellow
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = member.rating.toString(),
                            fontSize = 12.sp,
                            color = Color.White,
                            modifier = Modifier
                                .padding(start = 2.dp)
                                .padding(end = 4.dp)
                        )
                    }
                }

                Text(
                    text = member.name,
                    modifier = Modifier.constrainAs(name) {
                        top.linkTo(parent.top, margin = 16.dp)
                        start.linkTo(image.end, margin = 16.dp)
                    }
                )

                Text(
                    text = member.tipe_member,
                    modifier = Modifier.constrainAs(tipe_member) {
                        top.linkTo(name.bottom, margin = 4.dp)
                        start.linkTo(image.end, margin = 16.dp)
                    },
                    color = Color.Gray
                )

                Text(
                    text = "No. Kartu: ${member.nomor_kartu}",
                    modifier = Modifier.constrainAs(nomor_kartu) {
                        top.linkTo(tipe_member.bottom, margin = 4.dp)
                        start.linkTo(image.end, margin = 16.dp)
                    },
                    color = Color.Gray
                )
                Text(
                    text = "Masa Aktif : ${member.masaAktif}",
                    modifier = Modifier.constrainAs(masaAktif) {
                        top.linkTo(nomor_kartu.bottom, margin = 4.dp)
                        start.linkTo(image.end, margin = 16.dp)
                    }
                        .background(
                            color = Color(0xFF800080),
                            shape = RoundedCornerShape(8.dp),
                        )
                        .padding(start = 10.dp, end = 10.dp),
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = member.status,
                    modifier = Modifier.constrainAs(status) {
                        top.linkTo(parent.top, margin = 10.dp)
                        start.linkTo(image.end, margin = 170.dp)
                    }
                        .background(
                            color = Color(0xFF800080),
                            shape = RoundedCornerShape(8.dp),
                        )
                        .padding(start = 10.dp, end = 10.dp),
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MembershipScreenPreview() {
    MembershipScreen()
}

data class Member(val name: String, val tipe_member: String, val nomor_kartu: String, val rating: Float, val masaAktif: String, val status:String, val imageRes: Int)
