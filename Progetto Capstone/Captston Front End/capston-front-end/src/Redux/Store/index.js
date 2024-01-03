import storage from "redux-persist/lib/storage";
import tokenReducer from "../Reducers/tokenReducer";
import { configureStore, combineReducers } from "@reduxjs/toolkit";
import { persistStore, persistReducer } from "redux-persist";
import cartReducer from "../Reducers/cartReducer";
import fatturaReducer from "../Reducers/fatturaReducer";
const persistConfig = {
  key: "root ",
  storage,
};
const allReducers = combineReducers({
  bearer: tokenReducer,
  cart: cartReducer,
  fattura: fatturaReducer,
});

const persistedReducer = persistReducer(persistConfig, allReducers);

export const store = configureStore({
  reducer: persistedReducer,
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware({
      serializableCheck: false,
    }),
});
export const persistor = persistStore(store);
