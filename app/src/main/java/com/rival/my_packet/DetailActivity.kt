package com.rival.my_packet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.rival.my_packet.databinding.ActivityDetailBinding
import com.rival.my_packet.model.PaketItem
import com.rival.my_packet.model.PaketselesaiItem
import com.rival.my_packet.model.ResponseLanding
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))

        detailPaket()
        detailPaketSelesai()


    }

    private fun detailPaketSelesai() {
        val data = intent.getParcelableExtra<PaketselesaiItem>("Data2")
        if (data != null) {
            tv_nama_dtl.text = data?.nama_penerima
            tv_taggal_dtl.text = data?.tanggal_input
            tv_status_dtl.text = data?.status

            val UrlImage = "https://paket.siyap.co.id/storage/${data?.img}"

            Glide.with(this.img_paket_dtl)
                .load(UrlImage)
                .error(R.drawable.ic_launcher_background)
                .into(this.img_paket_dtl)
        }
    }

        private fun detailPaket() {
            val data = intent.getParcelableExtra<PaketItem>("Data")
            if (data != null) {
                tv_nama_dtl.text = data?.nama_penerima
                tv_taggal_dtl.text = data?.tanggal_input
                tv_status_dtl.text = data?.status

                val UrlImage = "https://paket.siyap.co.id/storage/${data?.img}"

                Glide.with(this.img_paket_dtl)
                    .load(UrlImage)
                    .error(R.drawable.ic_launcher_background)
                    .into(this.img_paket_dtl)
            }
        }
    }

