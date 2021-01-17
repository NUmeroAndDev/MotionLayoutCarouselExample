package jp.numero.carousel_example

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Carousel
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        val list = listOf(
                Color.MAGENTA,
                Color.RED,
                Color.CYAN,
                Color.BLUE,
                Color.GREEN,
                Color.YELLOW,
                Color.LTGRAY
        ).mapIndexed { index, color ->
            Item(index.toString(), color)
        }.toMutableList()

        val carousel = findViewById<Carousel>(R.id.carousel)
        carousel.setAdapter(object : Carousel.Adapter {
            override fun count(): Int = list.size

            override fun populate(view: View, index: Int) {
                if (view !is TextView) return
                val item = list[index]
                //view.text = item.text
                view.setBackgroundColor(item.color)
            }

            override fun onNewItem(index: Int) {
            }
        })
    }
}

data class Item(
        val text: String,
        val color: Int
)