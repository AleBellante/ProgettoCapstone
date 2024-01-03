import { Form, Button, Col } from "react-bootstrap";
import Card from "react-bootstrap/Card";
import { useEffect, useState } from "react";
import { addToCart, removeFromCart } from "../Redux/Actions/cartActions";

import { useSelector } from "react-redux";
import { useDispatch } from "react-redux";
const SingleProduct = (element) => {
  const dispatch = useDispatch();
  const [qntProdotto, setQntProdotto] = useState("");

  const bearer = useSelector((state) => state?.bearer?.bearer);
  const singleProduct = element.singleProduct;
  const nome = singleProduct?.productType;
  const immagine = singleProduct?.immagine;
  const qnt = singleProduct?.stockNum;
  const singleOrdine = { nomeprodotto: nome, qnt: qntProdotto };
  var nomeProdotto = "";
  switch (nome) {
    case "SWEETS":
      nomeProdotto = "Dolciumi";
      break;
    case "COFFEEMACHINE":
      nomeProdotto = "Macchina da caffè";
      break;
    case "COFFEEBAG":
      nomeProdotto = "Buste di caffé";
      break;
    case "COFFEEPOD":
      nomeProdotto = "Cialde";
      break;
    case "CHOCOLATEBARS":
      nomeProdotto = "Barrette di cioccolato";
      break;
    default:
      break;
  }
  useEffect(() => {
    console.log(element);
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  return (
    <Col>
      <Form className="mt-5 text-center">
        <Card style={{ width: "18rem" }}>
          <Card.Img variant="top" src={immagine} />
          <Card.Body>
            <Card.Title>{nomeProdotto}</Card.Title>
            <Card.Text>
              Il dev. ha sicuramente pensato ad una descrizione simpatica per
              questo prodotto, ma è possibile che abbia scordato di aggiungerla
            </Card.Text>
            {bearer && (
              <>
                {singleProduct.stockNum <= 0 ? (
                  <>
                    <Card.Text className="text-danger">
                      Stock insufficente
                    </Card.Text>
                  </>
                ) : (
                  <>
                    <Card.Text className="text-muted">
                      Inserisci quantità desiderata :
                    </Card.Text>
                    <Form.Control
                      onChange={(e) => setQntProdotto(e.target.value)}
                      value={qntProdotto}
                      type="number"
                      className="mb-4"
                      placeholder="Inserisci la quantità "
                    />
                    <Button
                      onClick={(e) => {
                        if (
                          singleOrdine.nomeprodotto === "" ||
                          singleOrdine.qnt === ""
                        ) {
                          alert("Per favore compila il campo campi");
                        } else if (singleOrdine.qnt > qnt) {
                          alert("Quantità in magazzino insufficente");
                        } else {
                          dispatch(addToCart(singleOrdine));
                        }
                        e.preventDefault();
                      }}
                      variant="primary"
                      type="submit"
                    >
                      Submit
                    </Button>
                    <Button
                      onClick={(e) => {
                        e.preventDefault();
                        dispatch(removeFromCart(singleProduct?.productType));
                      }}
                      variant="primary"
                      type="submit"
                      className="mt-1"
                    >
                      Elimina dal carrello
                    </Button>
                  </>
                )}
              </>
            )}
          </Card.Body>
        </Card>
      </Form>
    </Col>
  );
};

export default SingleProduct;
