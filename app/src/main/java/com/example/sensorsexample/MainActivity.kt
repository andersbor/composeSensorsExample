package com.example.sensorsexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.sensorsexample.ui.theme.SensorsExampleTheme
import com.mutualmobile.composesensors.rememberAccelerometerSensorState
import com.mutualmobile.composesensors.rememberLightSensorState
import com.mutualmobile.composesensors.rememberMagneticFieldSensorState
import com.mutualmobile.composesensors.rememberPressureSensorState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SensorsExampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        // https://devlibrary.withgoogle.com/products/android/repos/mutualmobile-ComposeSensors
                        val accelerometerState = rememberAccelerometerSensorState()
                        BorderedCard(
                            text = "Force X: ${accelerometerState.xForce}" +
                                    "\nForce Y: ${accelerometerState.yForce}" +
                                    "\nForce Z: ${accelerometerState.zForce}" +
                                    "\nIs Available?: ${accelerometerState.isAvailable}"
                        )


                        val lightState = rememberLightSensorState()
                        BorderedCard(
                            text = "Light Intensity: ${lightState.illuminance}" +
                                    "\nIs Available?: ${lightState.isAvailable}"
                        )

                        val pressureSensorState = rememberPressureSensorState()
                        BorderedCard(
                            text = "Pressure: ${pressureSensorState.pressure}" +
                                    "\nIs Available?: ${pressureSensorState.isAvailable}"
                        )

                        val magneticFieldSensorState = rememberMagneticFieldSensorState()
                        BorderedCard(
                            text = "Magnetic Field X: ${magneticFieldSensorState.xStrength}" +
                                    "\nMagnetic Field Y: ${magneticFieldSensorState.yStrength}" +
                                    "\nMagnetic Field Z: ${magneticFieldSensorState.zStrength}" +
                                    "\nIs Available?: ${magneticFieldSensorState.isAvailable}"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BorderedCard(text: String) {
    Card(
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = text
        )
    }
}