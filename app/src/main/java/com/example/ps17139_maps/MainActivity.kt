package com.example.ps17139_maps


import  android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ps17139_maps.adapter.OnClickListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val map=uniData()
        val recyclerview:RecyclerView=findViewById(R.id.recyclerview)
        recyclerview.layoutManager=LinearLayoutManager(this)
        recyclerview.adapter=adapter(this, map, object:OnClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity, MapsActivity::class.java)
                intent.putExtra("Uni_name",map[position])
                startActivity(intent)
            }
        })

    }

    private fun uniData(): List<Map> {
        return listOf(
            Map(
                "University Of Kelaniya",
                listOf(
                    item("University Of Kelaniya",6.974291810202281, 79.91569437424626)
                )
            ),

            Map(
                "University Of Moratuwa",
                listOf(
                    item("University Of Moratuwa", 6.795393931813083, 79.90084553928628)
                )
            ),
            Map(
                "University Of Sri Jayawardanapura",
                listOf(
                    item("University Of Sri Jayawardanapura",6.853107869942087, 79.90352520299508)
                )
            ),

            Map(
                "University Of Colombo",
                listOf(
                    item("University Of Colombo", 6.900270522070662, 79.85880452579408)
                )
            ),

            Map(
                "University Of Peradeniya",
                listOf(
                    item("University Of Peradeniya", 7.259506630525971, 80.59862941501063)
                )
            ),
            Map(
                "University Of Sabaragamuwa",
                listOf(
                    item("University Of Sabaragamuwa", 6.714484642684733, 80.78716485245869)
                )
            ),
            Map(
                "University Of Ruhuna",
                listOf(
                    item("University Of Ruhuna", 5.938294849755356, 80.57611293896441)
                )
            )
            ,
            Map(
                "University Of Jaffna",
                listOf(
                    item("University Of Jaffna", 9.685849642733507, 80.02182663291065)
                )
            ),

            Map(
                "Eastern University Of Sri Lanka",
                listOf(
                    item("Eastern University Of Sri Lanka", 7.794549980636313, 81.57894228315078)
                )
            ),
            Map(
                "South Eastern University Of Sri Lanka",
                listOf(
                    item("South Eastern University Of Sri Lanka", 7.297095498060887, 81.8498289487568)
                )
            ),

            Map(
                "Wayamba University Of Sri Lanka",
                listOf(
                    item("Wayamba University Of Sri Lanka", 7.322747373376586, 79.98817338129685)
                )
            ),
            Map(
                "Rajarata University Of Sri Lanka",
                listOf(
                    item("Rajarata University Of Sri Lanka", 8.361842831410156, 80.50466492177746)
                )
            ),
            Map(
                "Uva Wellassa University Of Sri Lanka",
                listOf(
                    item("Uva Wellassa University Of Sri Lanka", 6.9819803891756, 81.07642247150756)
                )
            ),

        )
    }
}