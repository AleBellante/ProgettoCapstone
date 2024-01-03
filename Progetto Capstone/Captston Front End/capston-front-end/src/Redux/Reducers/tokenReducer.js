import { ADD_KEY, REMOVE_KEY } from "../Actions/postLoginActions";
const initialState = {
  bearer: "",
};

const tokenReducer = (state = initialState, action) => {
  switch (action.type) {
    case ADD_KEY:
      return {
        ...state,
        bearer: action.payload,
      };
    case REMOVE_KEY:
      return {
        ...state,
        bearer: "",
      };
    default:
      return state;
  }
};
export default tokenReducer;
