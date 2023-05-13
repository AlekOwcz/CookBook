package com.example.cookbookapp


import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.NumberPicker
import androidx.fragment.app.Fragment


class StopperFragment : Fragment(), View.OnClickListener {

    override fun onClick(v: View) {
        when (v.id) {
            R.id.start_button -> onClickStart(v)
            R.id.stop_button -> onClickStop(v)
            R.id.reset_button -> onClickReset(v)
        }
    }
    private var mediaPlayer: MediaPlayer? = null
    private var mediaPlayer2: MediaPlayer? = null
    private var seconds = 0
    private var running = false
    private var wasRunning = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.fragment_stopper, container, false)
        runStoper(layout)
        val startButton: Button = layout.findViewById(R.id.start_button) as Button
        startButton.setOnClickListener(this)

        val stopButton: Button = layout.findViewById(R.id.stop_button) as Button
        stopButton.setOnClickListener(this)

        val resetButton: Button = layout.findViewById(R.id.reset_button) as Button
        resetButton.setOnClickListener(this)

        val hourPicker = layout.findViewById<NumberPicker>(R.id.hour_picker)
        val minutePicker = layout.findViewById<NumberPicker>(R.id.minute_picker)
        val secondPicker = layout.findViewById<NumberPicker>(R.id.second_picker)
        hourPicker.maxValue = 23
        hourPicker.minValue = 0

        minutePicker.maxValue = 59
        minutePicker.minValue = 0

        secondPicker.maxValue = 59
        secondPicker.minValue = 0
        hourPicker.setOnValueChangedListener { _, _, _ ->
            seconds = hourPicker.value * 3600 + minutePicker.value * 60 + secondPicker.value
        }

        minutePicker.setOnValueChangedListener { _, _, _ ->
            seconds = hourPicker.value * 3600 + minutePicker.value * 60 + secondPicker.value
        }

        secondPicker.setOnValueChangedListener { _, _, _ ->
            seconds = hourPicker.value * 3600 + minutePicker.value * 60 + secondPicker.value
        }
        return layout
    }


    private fun runStoper(view: View) {
        mediaPlayer = MediaPlayer.create(view.context, R.raw.alarm)
        mediaPlayer2 = MediaPlayer.create(view.context, R.raw.alarm2)
        val hourPicker = view.findViewById<NumberPicker>(R.id.hour_picker)
        val minutePicker = view.findViewById<NumberPicker>(R.id.minute_picker)
        val secondPicker = view.findViewById<NumberPicker>(R.id.second_picker)
        val handler = Handler(Looper.getMainLooper())
        handler.post(object : Runnable {
            override fun run() {
                val hours = seconds / 3600
                val minutes = (seconds % 3600) / 60
                val secs = seconds % 60
                hourPicker.value = hours
                minutePicker.value = minutes
                secondPicker.value = secs
                if (running && seconds >= 0) {
                    seconds--
                }
                if (seconds == -1) {
                    seconds = 0
                    if (running) {
                        mediaPlayer?.start()
                        mediaPlayer2?.start()
                        hourPicker.isEnabled = true
                        minutePicker.isEnabled = true
                        secondPicker.isEnabled = true
                    }
                    running = false
                }
                handler.postDelayed(this, 1000)
            }
        })
    }
    override fun onPause() {
        super.onPause()
        wasRunning = running
        running = false
    }
    override fun onResume() {
        super.onResume()
        if(wasRunning) running = true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("seconds",seconds)
        outState.putBoolean("running",running)
        outState.putBoolean("wasRunning",wasRunning)
    }

    private fun onClickStart(view: View){
        val parentView = view.parent as View
        val linearLayout = parentView.parent as LinearLayout
        val hourPicker = linearLayout.findViewById<NumberPicker>(R.id.hour_picker)
        val minutePicker = linearLayout.findViewById<NumberPicker>(R.id.minute_picker)
        val secondPicker = linearLayout.findViewById<NumberPicker>(R.id.second_picker)
        hourPicker.isEnabled = false
        minutePicker.isEnabled = false
        secondPicker.isEnabled = false
        running = true
    }

    private fun onClickStop(view: View) {
        val parentView = view.parent as View
        val linearLayout = parentView.parent as LinearLayout
        val hourPicker = linearLayout.findViewById<NumberPicker>(R.id.hour_picker)
        val minutePicker = linearLayout.findViewById<NumberPicker>(R.id.minute_picker)
        val secondPicker = linearLayout.findViewById<NumberPicker>(R.id.second_picker)
        hourPicker.isEnabled = true
        minutePicker.isEnabled = true
        secondPicker.isEnabled = true
        running = false
    }

    private fun onClickReset(view: View) {
        val parentView = view.parent as View
        val linearLayout = parentView.parent as LinearLayout
        val hourPicker = linearLayout.findViewById<NumberPicker>(R.id.hour_picker)
        val minutePicker = linearLayout.findViewById<NumberPicker>(R.id.minute_picker)
        val secondPicker = linearLayout.findViewById<NumberPicker>(R.id.second_picker)
        hourPicker.isEnabled = true
        minutePicker.isEnabled = true
        secondPicker.isEnabled = true
        running = false
        seconds = 0
    }





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds")
            running = savedInstanceState.getBoolean("running")
            wasRunning = savedInstanceState.getBoolean("wasRunning")
        }
    }
}