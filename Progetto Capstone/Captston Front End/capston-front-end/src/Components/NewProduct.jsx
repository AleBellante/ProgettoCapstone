import { useState } from "react";
import { Button, Card, Form } from "react-bootstrap";
import { useSelector } from "react-redux";

const NewProduct = () => {
  const [nomeProdotto, setNomeProdotto] = useState("");
  const [stock, setStock] = useState("");
  const [immagine, setImmagine] = useState("");
  const [prz, setPrz] = useState("");

  const res = useSelector((state) => state.bearer.bearer);
  const jwt = res.accessToken;
  const baseEndpoint = "http://localhost:8080/products/save";
  const postNewProduct = async () => {
    let response = await fetch(baseEndpoint, {
      method: "POST",
      headers: {
        authorization: `Bearer  ${jwt}`,
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        productType: nomeProdotto.toUpperCase(),
        stockNum: stock,
        immagine: immagine,
        prezzounitario: prz,
      }),
    });
    const res = await response.json();
    console.log(res);
  };
  return (
    <>
      <Card className="d-flex align-items-center mt-3">
        <p className="mt-3">Crea il tuo nuovo prodotto!</p>
        <Form className="d-flex align-items-center">
          <Form.Group className="mb-3 text-center">
            <Form.Label className="te">Nome</Form.Label>
            <Form.Control
              style={{ width: "18rem" }}
              onChange={(e) => setNomeProdotto(e.target.value)}
              value={nomeProdotto}
              type="input"
              className="mb-4 text-center"
              placeholder="Inserisci nome prodotto"
            />
            <Form.Label className="te">Quantità stock</Form.Label>
            <Form.Control
              onChange={(e) => setStock(e.target.value)}
              value={stock}
              type="number"
              className="mb-4  text-center"
              placeholder="Inserisci la quantità di stock iniziale"
            />
            <Form.Label className="te">Immagine</Form.Label>
            <Form.Control
              onChange={(e) => setImmagine(e.target.value)}
              value={immagine}
              type="input"
              className="mb-4  text-center"
              placeholder="Inserisci URL immagine"
            />
            <Form.Label className="te">Prezzo Unitario</Form.Label>
            <Form.Control
              onChange={(e) => setPrz(e.target.value)}
              value={prz}
              type="number"
              className="mb-4  text-center"
              placeholder="Inserisci un prezzo unitario (es 0.2)"
            />
          </Form.Group>
        </Form>
        <Button
          className="d-flex justify-content-center mb-2"
          onClick={(e) => {
            e.preventDefault();
            postNewProduct();
            console.log(jwt);
            if (
              nomeProdotto === "" ||
              // immagine === "" ||
              prz === "" ||
              stock === ""
            ) {
              alert("Per favore compila tutti i campi");
            } else {
            }
          }}
          variant="primary"
          type="submit"
        >
          Submit
        </Button>
      </Card>
    </>
  );
};
export default NewProduct;
