export const SAVE_ORDER = "SAVE_ORDER";

const baseEndpoint = `http://localhost:8080/fatture/save/fattura/`;
export const saveFattura = (fattura, username) => {
  return async (dispatch) => {
    try {
      const response = await fetch(baseEndpoint + username, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({}),
      });
      const data = await response.json();
      dispatch({
        type: SAVE_ORDER,
        payload: fattura,
      });
    } catch (error) {
      console.log(error);
    }
  };
};
