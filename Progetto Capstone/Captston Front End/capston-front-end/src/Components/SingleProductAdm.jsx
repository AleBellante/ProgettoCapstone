import { useEffect, useState } from "react";
import { Button, Card, Form } from "react-bootstrap";
import { useSelector } from "react-redux";

const SingleProductAdm = (element) => {
  const [qntProdotto, setQntProdotto] = useState("");

  const baseEndpoint = "http://localhost:8080/products/";
  const bearer = useSelector((state) => state?.bearer?.bearer);
  const singleProduct = element.singleProduct;
  const nome = singleProduct?.productType;
  const immagine = singleProduct?.immagine;
  // const [refresh, setRefresh] = useState(refreshed);

  //   const [item, setItem] = useState();
  const deleteProdotto = async () => {
    try {
      const result = await fetch(baseEndpoint + "delete", {
        method: "DELETE",
        headers: {
          authorization: `Bearer  ${bearer.accessToken}`,
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          productType: nome,
        }),
      });
      if (result.ok) {
        const res = await result.json();
        console.log(res);
        alert("prodotto eliminato!");
      }
    } catch (error) {
      console.log(error);
    }
  };
  useEffect(() => {}, []);

  return (
    <>
      <Form className="text-center">
        <Card style={{ width: "18rem" }}>
          <Card.Img variant="top" src={immagine} />
          <Card.Body>
            <Card.Title>{nome}</Card.Title>
            <Card.Text className="text-center">
              Some quick example text to build on the card title and make up the
              bulk of the card's content.
            </Card.Text>
            {bearer && (
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
                    deleteProdotto();
                    e.preventDefault();
                    //console.log(nome);
                  }}
                  variant="primary"
                  type="submit"
                >
                  Elimina Prodotto
                </Button>
              </>
            )}
          </Card.Body>
        </Card>
      </Form>
      ;
    </>
  );
};

export default SingleProductAdm;
