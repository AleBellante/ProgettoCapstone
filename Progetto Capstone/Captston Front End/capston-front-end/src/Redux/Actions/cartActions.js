export const ADD_ITEM = "ADD_ITEM";
export const REMOVE_ITEM = "REMOVE_ITEM";
export const CLEAR_CART = "CLEAR_CART";
export const CHANGE_ITEM = "CHANGE_ITEM";

export const addToCart = (item) => {
  return {
    type: ADD_ITEM,
    payload: item,
  };
};
export const removeFromCart = (itemName) => {
  return {
    type: REMOVE_ITEM,
    payload: itemName,
  };
};
export const clearCart = () => {
  return {
    type: CLEAR_CART,
  };
};
