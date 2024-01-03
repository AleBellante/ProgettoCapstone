import { useSelector } from "react-redux";
import { useEffect } from "react";
import { useState } from "react";
import FatturaCard from "./FatturaCard";
import { Card, Container } from "react-bootstrap";
const baseEndpoint = "http://localhost:8080/fatture/cliente/";
const AreaCliente = () => {
  const res = useSelector((state) => state.bearer.bearer);
  const [fatture, setFatture] = useState();
  const username = res.username;

  const fetchFatture = async () => {
    try {
      const result = await fetch(baseEndpoint + username, {
        method: "GET",
        headers: {
          authorization: `Bearer  ${res.accessToken}`,
          "Content-Type": "application/json",
        },
      });
      if (result.ok) {
        const res = await result.json();
        setFatture(res.content);
        console.log(fatture);
      }
    } catch (error) {
      console.log(error);
    }
  };
  useEffect(() => {
    fetchFatture();

    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);
  return (
    <Container>
      <Card className="d-flex justify-content-center">
        <Container className="mt-2">
          <p>Ecco un elenco delle tue fatture : </p>
        </Container>
        <Container className="">
          ------------------------------------
          {fatture?.map((element) => (
            <>
              <div>
                <Card.Text>ID Ordine: {element.id}</Card.Text>
                <FatturaCard content={element.ordine}></FatturaCard>
                <p>Totale Fattura: {element.importo} $</p>
              </div>
              ------------------------------------
            </>
          ))}
        </Container>
      </Card>
    </Container>
  );
};
export default AreaCliente;
