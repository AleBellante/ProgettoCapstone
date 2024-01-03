import { useEffect, useState } from "react";
import SingleProduct from "./SingleProduct";

import { useSelector } from "react-redux";
import { Container, Row } from "react-bootstrap";
const ProductPage = () => {
  const jwtToken = useSelector((state) => state.bearer.bearer);
  const [listaProdotti, setListaProdotti] = useState([]);

  const baseEndpoint = "http://localhost:8080/products/all";
  useEffect(() => {
    fetchProdotti();
    console.log(listaProdotti);
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);
  const fetchProdotti = async () => {
    try {
      const result = await fetch(baseEndpoint, {
        method: "GET",
        headers: {
          authorization: `Bearer  ${jwtToken.accessToken}`,
          "Content-Type": "application/json",
        },
      });
      if (result.ok) {
        const res = await result.json();
        const prodList = await res?.content;
        setListaProdotti(prodList);
        console.log(result.body);
      }
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <Container id="productPage">
      <Row>
        {listaProdotti &&
          listaProdotti.map((element) => {
            return (
              <SingleProduct
                singleProduct={element}
                key={element.id}
              ></SingleProduct>
            );
          })}
      </Row>
    </Container>
  );
};

export default ProductPage;
