export const GET_KEY = "GET_KEY";
export const ADD_KEY = "ADD_KEY";
export const REMOVE_KEY = "REMOVE_KEY";
const baseEndpoint = "http://localhost:8080/api/auth/login";
export const postLogin = (username, password) => {
  return async (dispatch) => {
    try {
      const response = await fetch(baseEndpoint, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          username: username,
          password: password,
        }),
      });
      const data = await response.json();
      dispatch({
        type: ADD_KEY,
        payload: data,
      });
    } catch (error) {
      console.log(error);
    }
  };
};
export const logOut = () => {
  return {
    type: REMOVE_KEY,
  };
};
