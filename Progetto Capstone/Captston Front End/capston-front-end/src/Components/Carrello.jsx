import { useEffect, useState } from "react";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import { useDispatch } from "react-redux";
import Row from "react-bootstrap/Row";
import { useSelector } from "react-redux";
import { Card, Col, Container, FormGroup } from "react-bootstrap";

import CarrelloItem from "./CarrelloItem";
import { clearCart } from "../Redux/Actions/cartActions";
const Carrello = () => {
  const dispatch = useDispatch();
  const listaOrdini = useSelector((state) => state?.cart?.cart);
  const res = useSelector((state) => state.bearer.bearer);
  const username = res.username;
  const ordine = listaOrdini;
  const [consegna, setConsegna] = useState();
  const baseEndpoint = `http://localhost:8080/fatture/save/fattura/${username}`;

  const postFattura = async () => {
    try {
      const result = await fetch(baseEndpoint, {
        method: "POST",
        headers: {
          authorization: `Bearer  ${res.accessToken}`,
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          tipologia: consegna,
          ordine,
        }),
      });
      if (result.ok) {
        const res = await result.json();
        console.log(res);
        alert("ordine salvato con successo!");
      }
    } catch (error) {
      console.log(error);
    }
  };
  useEffect(() => {
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [listaOrdini]);
  return (
    <Container>
      <Row className="justify-content-center align-items-center mt-5">
        <Col>
          <Card>
            <Form>
              <FormGroup>
                {listaOrdini.map((element) => (
                  <>
                    <p>Controlla i dettagli del tuo ordine</p>
                    <CarrelloItem
                      item={element}
                      key={element.nomeprodotto}
                    ></CarrelloItem>
                  </>
                ))}
                {Object.keys(listaOrdini).length === 0 ? (
                  <>
                    <Card id="carrelloPreRender" className="text-center">
                      Aggiungi qualcosa al carrello prima
                    </Card>
                  </>
                ) : (
                  <>
                    <select
                      name="industry"
                      class="form-control"
                      onChange={(e) => setConsegna(e.target.value)}
                      value={consegna}
                    >
                      <option value="" disabled selected>
                        Seleziona tipologia consegna
                      </option>
                      <option value="CONSEGNA">Consegna</option>
                      <option value="PRENOTAZIONE">Prenotazione</option>
                    </select>
                    <Button
                      className="mt-5"
                      onClick={(e) => {
                        e.preventDefault();
                        if (ordine) {
                          postFattura();
                          dispatch(clearCart());
                          console.log("ciao");
                        } else {
                          alert("qualcosa è andata storta");
                        }
                        console.log(listaOrdini);
                      }}
                    >
                      Procedi con la spedizione!
                    </Button>
                    <Button
                      className="mt-5"
                      onClick={(e) => {
                        e.preventDefault();
                        dispatch(clearCart());
                      }}
                    >
                      {" "}
                      pulisci carrello
                    </Button>
                  </>
                )}
              </FormGroup>
            </Form>
          </Card>
        </Col>
      </Row>
    </Container>
  );
};
export default Carrello;
