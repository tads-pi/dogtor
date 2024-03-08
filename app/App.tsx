import React from 'react'
import { StyleSheet, Text, View } from 'react-native'
import { useFonts } from 'expo-font'

export default function App() {
    const [fontsLoaded] = useFonts({
        'Barlow-Light': require('./src/assets/fonts/Barlow-Light.ttf'),
        Inter: require('./src/assets/fonts/Inter.ttf'),
    })

    if (!fontsLoaded) {
        return <Text>Loading...</Text>
    }

    return (
        <View style={styles.container}>
            <Text style={styles.text}>Font-test</Text>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff',
        alignItems: 'center',
        justifyContent: 'center',
    },
    text: {
        fontWeight: '100',
        fontSize: 48,
    },
})
