import React from 'react';

const AppContext = React.createContext({
  cache: [],
  settingsFastQuizDepartment: {},
  settingsDestinationURL: "",
  settingsAuthor: "",
  settingsPageSize: "",
  isDebugMode: false,
  setSettingsDestinationURL: (val) => {},
  setSettingsAuthor: (val) => {},
  setSettingsPageSize: (val) => {},
  setSettingsFastQuizDepartment: (val) => {},
  existInCache: (val) => {},
  addToCache: (val) => {},
  setDebugMode: (val) => {},
});

export default AppContext;