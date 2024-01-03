import { Navbar, Nav, NavLink, NavItem } from "react-bootstrap";
import { useDispatch } from "react-redux";
import { useSelector } from "react-redux";
import { logOut } from "../Redux/Actions/postLoginActions";
import { useEffect, useState } from "react";
const NavBar = () => {
  const userLogged = useSelector((state) => state?.bearer?.bearer);

  const [ruoli, setRuoli] = useState();
  const listRuoli = userLogged?.roles;
  const dispatch = useDispatch();

  useEffect(() => {
    setRuoli(listRuoli);
    console.log(ruoli);
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [listRuoli]);

  return (
    <Navbar className="navBar navbar-light bg-light sticky-top">
      <NavLink href="/" className="ms-3">
        <img
          style={{ width: "5rem" }}
          src="https://freepngimg.com/thumb/coffee/33957-5-coffee-logo-transparent-background.png"
          alt="logo"
        ></img>
      </NavLink>
      <Nav className="container ">
        {ruoli && (
          <>
            <Nav.Item>Sei loggato come: {userLogged.username}</Nav.Item>
            <Nav.Item>
              <Nav.Link
                className="navLink text-black fw-bold p-3"
                href="/products"
              >
                Prodotti
              </Nav.Link>
            </Nav.Item>
          </>
        )}

        {ruoli && ruoli[0].roleName === "ROLE_ADMIN" ? (
          <>
            <NavLink
              className="navLink text-black fw-bold p-3"
              onClick={(e) => {
                e.preventDefault();
                dispatch(logOut());
              }}
            >
              Logout
            </NavLink>
          </>
        ) : (
          userLogged.accessToken && (
            <>
              <Nav.Link
                href="/carrello"
                className="text-black fw-bold p-3 navLink"
              >
                Carrello
              </Nav.Link>
              <NavLink
                className="navLink text-black fw-bold p-3"
                onClick={(e) => {
                  e.preventDefault();
                  dispatch(logOut());
                }}
              >
                Logout
              </NavLink>
            </>
          )
        )}
        {!userLogged.accessToken && (
          <Nav.Item>
            <Nav.Link href="/login" className="text-black fw-bold p-3 navLink">
              Login
            </Nav.Link>
          </Nav.Item>
        )}
        {!userLogged.accessToken && (
          <Nav.Item className="ml-auto ">
            <Nav.Link
              href="/register"
              className="text-black fw-bold p-3 navLink"
            >
              Registrati!
            </Nav.Link>
          </Nav.Item>
        )}
        {ruoli && ruoli[0].roleName === "ROLE_ADMIN" ? (
          <>
            <Nav.Item className="ml-auto ">
              <Nav.Link
                href="/area-admin"
                className="text-black fw-bold p-3 navLink"
              >
                Admin Area
              </Nav.Link>
            </Nav.Item>
          </>
        ) : (
          ruoli &&
          ruoli[0].roleName === "ROLE_USER" && (
            <Nav.Item className="ml-auto ">
              <Nav.Link
                href="/area-cliente"
                className="text-black fw-bold p-3 navLink"
              >
                Area Cliente
              </Nav.Link>
            </Nav.Item>
          )
        )}
      </Nav>
    </Navbar>
  );
};

export default NavBar;
