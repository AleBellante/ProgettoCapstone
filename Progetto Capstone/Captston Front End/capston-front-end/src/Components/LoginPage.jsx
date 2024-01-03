import { useState } from "react";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import { postLogin } from "../Redux/Actions/postLoginActions";
import { useDispatch } from "react-redux";
import { Container, Row } from "react-bootstrap";
const LoginPage = () => {
  const dispatch = useDispatch();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  return (
    <>
      <Container fluid className="pageContent mainContent">
        <Row id="registrationPage" className="m-0 pb-3">
          <Container>
            <Container className="p-0 my-3 mb-5 rounded">
              <Container>
                <Form>
                  <Form.Group className="mb-3">
                    <Form.Label>Username</Form.Label>
                    <Form.Control
                      onChange={(e) => setUsername(e.target.value)}
                      value={username}
                      type="input"
                      className="mb-4"
                      placeholder="Inserisci il tuo username"
                    />
                    <Form.Label>Password</Form.Label>
                    <Form.Control
                      onChange={(e) => setPassword(e.target.value)}
                      value={password}
                      type="password"
                      className="mb-4"
                      placeholder="Inserisci la tua password"
                    />
                  </Form.Group>
                  <Button
                    onClick={(e) => {
                      e.preventDefault();
                      if (username === "" || password === "") {
                        alert("Per favore compila tutti i campi");
                      } else {
                        dispatch(postLogin(username, password));
                      }
                    }}
                    variant="primary"
                    type="submit"
                  >
                    Submit
                  </Button>
                </Form>
              </Container>
            </Container>
          </Container>
        </Row>
      </Container>
    </>
  );
};
export default LoginPage;
