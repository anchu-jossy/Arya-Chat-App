import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aryacodingtest.R
import com.example.aryacodingtest.ui.component.GradientRoundIcon

/**
 * A composable function representing an attachment option item with an icon and text.
 *
 * @param iconRes Resource ID of the icon to be displayed.
 * @param text The text label for the option.
 * @param gradientColors List of colors used for the gradient background of the icon.
 */
@Composable
fun AttachOptionItem(
    iconRes: Int,
    text: String,
    gradientColors: List<Color>
) {
    val InterRegular = FontFamily(
        Font(R.font.inter_regular, FontWeight.SemiBold) // Ensure this font is available in res/font
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp), // Adds padding for better spacing
        verticalAlignment = Alignment.CenterVertically // Aligns items centrally within the row
    ) {
        // Gradient circular icon
        GradientRoundIcon(
            iconRes = iconRes,
            contentDescription = text,
            gradientColors = gradientColors,
            size = 50 // Sets the size of the icon
        )

        Spacer(modifier = Modifier.width(12.dp)) // Adds spacing between icon and text

        // Display text with styling
        Text(
            text = text,
            fontSize = 18.sp, fontFamily = InterRegular,
            color = Color.White // Ensures visibility on dark backgrounds
        )
    }
}
