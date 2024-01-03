import { Card } from "react-bootstrap";
const FatturaCard = ({ content }) => {
  return content?.map((element) => (
    <>
      <Card.Text>
        {element.nomeprodotto}: {element.qnt}{" "}
      </Card.Text>
    </>
  ));
};
export default FatturaCard;
