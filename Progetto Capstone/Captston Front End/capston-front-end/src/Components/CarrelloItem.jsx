import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import { useDispatch } from "react-redux";
import { useState } from "react";
import { addToCart, removeFromCart } from "../Redux/Actions/cartActions";
import { Card, Container } from "react-bootstrap";
const CarrelloItem = ({ item }) => {
  const dispatch = useDispatch();

  const [qntProdotto, setQntProdotto] = useState("");
  const nome = item.nomeprodotto;
  const qnt = qntProdotto;
  const singleOrdine = { nomeprodotto: nome, qnt };

  return (
    <>
      <p className="">
        {item?.nomeprodotto} : {item?.qnt}
      </p>
      <Form.Control
        onChange={(e) => setQntProdotto(e.target.value)}
        value={qnt}
        type="number"
        className="mb-4"
        placeholder="Se desideri modificarla, inserisci la quantità "
      />
      <Button
        style={{ width: "10rem" }}
        onClick={(e) => {
          e.preventDefault();
          dispatch(removeFromCart(item.nomeprodotto));
          console.log(qntProdotto);
          if (qntProdotto === "0") {
            dispatch(removeFromCart(item.nomeprodotto));
            alert("Oggetto rimosso");
          } else {
            dispatch(addToCart(singleOrdine));
            alert("oggetto aggiunto");
          }
        }}
        variant="primary"
        type="submit"
      >
        Submit
      </Button>
    </>
  );
};
export default CarrelloItem;
