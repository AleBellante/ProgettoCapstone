import { ADD_ITEM } from "../Actions/cartActions";
import { REMOVE_ITEM } from "../Actions/cartActions";
import { CLEAR_CART } from "../Actions/cartActions";
const initialState = {
  cart: [],
};

const cartReducer = (state = initialState, action) => {
  switch (action.type) {
    case ADD_ITEM:
      if (
        state.cart.find(
          (element) => element.nomeprodotto === action.payload?.nomeprodotto
        )
      ) {
        return { ...state };
      } else
        return {
          ...state,
          cart: [...state.cart, action.payload],
        };
    case REMOVE_ITEM:
      return {
        ...state,
        cart: state.cart.filter(
          (element) => element.nomeprodotto !== action.payload
        ),
      };

    case CLEAR_CART:
      return {
        ...state,
        cart: [],
      };
    default:
      return state;
  }
};

export default cartReducer;
