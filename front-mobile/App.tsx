import { StatusBar } from 'expo-status-bar';
import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { AppLoading } from 'expo';
import {
  useFonts,
  Play_400Regular,
  Play_700Bold,
} from '@expo-google-fonts/play';

import Routes from './src/routes';

export default function App() {
  const [fontsLoaded] = useFonts({
    Play_400Regular,
    Play_700Bold
  });

  if(!fontsLoaded){//Caso a fonte não carregar ele apresenta o load nativo do expo;
    return <AppLoading />
  }else{
    return (
      <View style={styles.container}>
        <Routes />
        <StatusBar style="light" />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1
  }
});
/*
O componete <StatusBar> manipula a barra superior do telfone, onde fica o sinal de wifi, bateria,
etc, (auto, light)
*/