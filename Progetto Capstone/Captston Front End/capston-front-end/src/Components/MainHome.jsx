import { Container, ListGroup, ListGroupItem } from "react-bootstrap";

const MainHome = () => {
  return (
    <Container>
      <div class="split left ">
        <div class="centered">
          <ListGroup>
            <ListGroupItem className="bg-transparent mb-5">
              casdadasda
            </ListGroupItem>
            <ListGroupItem className="bg-transparent mb-1">
              asdadsada
            </ListGroupItem>
            <ListGroupItem className="bg-transparent mt-5">
              asdasdasdsa
            </ListGroupItem>
          </ListGroup>
        </div>
      </div>
      <div class="split right ">
        <div class="centered">
          <ListGroup>
            <ListGroupItem className="bg-transparent mb-5">
              casdadasda
            </ListGroupItem>
            <ListGroupItem className="bg-transparent mb-1">
              asdadsada
            </ListGroupItem>
            <ListGroupItem className="bg-transparent mt-5">
              asdasdasdsa
            </ListGroupItem>
          </ListGroup>
        </div>
      </div>
    </Container>
  );
};
export default MainHome;
