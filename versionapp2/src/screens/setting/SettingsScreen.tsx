import React, { useContext, useState } from "react";
import {View, ScrollView} from 'react-native';
import  AsyncStorage  from '@react-native-async-storage/async-storage';
import AppContext from "../../store/AppContext";
import PackageJson from '../../../package.json';
import { Button, InputText , InputTextField, InputSwitch }  from '../../components/Form.tsx';
import { showMessage } from "react-native-flash-message";
import styles from './SettingsSheetStyles';


const useSettingsFormState = () => {
  const appCtx = useContext(AppContext);
  const [author, setAuthor] = useState(appCtx.settingsAuthor);
  const [pageSize, setPageSize] = useState(appCtx.settingsPageSize);
  const [destinationURL, setDestinationURL] = useState(appCtx.settingsDestinationURL);
  const [isDebugMode, setDebugMode] = useState(appCtx.isDebugMode);
  const [submit, setSubmit] = useState(false);

  let destinationURLValid = false;
  let authorValid = false;
  let pageSizeValid = false;
  let isDebugModeValid = false;

  async function saveData(key, value) {
    await AsyncStorage.setItem(key,value);
  }

  return {
    destinationURL: {
      value: destinationURL,
      set: setDestinationURL,
      valid: destinationURLValid
    },
    author: {
      value: author,
      set: setAuthor,
      valid: authorValid
    },
    pageSize: {
      value: pageSize,
      set: setPageSize,
      valid: pageSizeValid
    },
    isDebugMode: {
      value: isDebugMode,
      set: setDebugMode,
      valid: isDebugModeValid
    },
    submit: {
      value: submit,
      set: () => {
          setSubmit(true);
          appCtx.setSettingsDestinationURL(destinationURL);
          appCtx.setSettingsAuthor(author);
          appCtx.setSettingsPageSize(pageSize);
          appCtx.setDebugMode(isDebugMode);
          
          saveData('@storage_versions2',  JSON.stringify({
            destinationURL: destinationURL,
            author: author,
            pageSize: pageSize,
            isDebugMode: isDebugMode
          }));

          showMessage({
            message: "Ustawienia zostały aktualizowane",
            type: "info",
            statusBarHeight: 40
        });
      },
      valid: true
    }
  }
}

const SettingsScreen = () => {
  const { destinationURL, isDebugMode, author, pageSize, submit} = useSettingsFormState();

  return (
    <ScrollView  >
      <View  style={styles.mainContainer}>
        <View >
          <InputText
              label="Wersja"
              description={PackageJson.version} />
          <InputTextField 
            label="API Url" 
            onChange={destinationURL.set} 
            value={destinationURL.value}
            />
          <InputTextField 
            label="Autor" 
            onChange={author.set} 
            value={author.value}
            />
          <InputTextField 
            label="Rozmiar stronicowania" 
            onChange={pageSize.set} 
            value={pageSize.value}
            keyboardType='numeric'
            />
          <InputSwitch 
            description="Tryb debug" 
            onChange={isDebugMode.set} 
            value={isDebugMode.value}
            />
          
          <Button
              text="Zapisz"
              testID="SettingsScreen.SubmitButton"
              onPress={submit.set} />
        </View>
      </View>
    </ScrollView>
  );
};

export default SettingsScreen;
