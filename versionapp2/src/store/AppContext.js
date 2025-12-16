import React from 'react';

const AppContext = React.createContext({
  cache: [],
  settingsFastQuizDepartment: {},
  settingsDestinationURL: "",
  settingsAuthor: "",
  isDebugMode: false,
  setSettingsDestinationURL: (val) => {},
  setSettingsAuthor: (val) => {},
  setSettingsFastQuizDepartment: (val) => {},
  existInCache: (val) => {},
  addToCache: (val) => {},
  setDebugMode: (val) => {},
});

export default AppContext;