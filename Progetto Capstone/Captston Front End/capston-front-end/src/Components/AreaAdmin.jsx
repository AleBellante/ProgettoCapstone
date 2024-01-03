import { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import SingleProductAdm from "./SingleProductAdm";
import NewProduct from "./NewProduct";
import { Col, Container, Row } from "react-bootstrap";

const baseEndpoint = "http://localhost:8080/products/all";

const AreaAdmin = () => {
  const res = useSelector((state) => state.bearer.bearer);

  const [listaProdotti, setListaProdotti] = useState([]);

  const fetchProdotti = async () => {
    try {
      const result = await fetch(baseEndpoint, {
        method: "GET",
        headers: {
          authorization: `Bearer  ${res.accessToken}`,
          "Content-Type": "application/json",
        },
      });
      if (result.ok) {
        const res = await result.json();
        const prodList = await res?.content;
        setListaProdotti(prodList);
      }
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    fetchProdotti();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);
  return (
    <>
      <Container id="productPageAdmn " className="mt-5">
        <Container className="d-flex justify-content-center">
          <Row className="">
            {listaProdotti &&
              listaProdotti.map((element) => {
                return (
                  <>
                    <Col>
                      <SingleProductAdm
                        singleProduct={element}
                        key={element?.productType}
                      ></SingleProductAdm>
                    </Col>
                  </>
                );
              })}
          </Row>
        </Container>
        <Container className="d-flex justify-content-center ">
          <Row className="mt-5 ">
            <NewProduct></NewProduct>
          </Row>
        </Container>
      </Container>
    </>
  );
};
export default AreaAdmin;
