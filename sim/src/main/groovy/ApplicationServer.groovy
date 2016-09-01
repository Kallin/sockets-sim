import game.Game
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.websocket.server.WebSocketHandler
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory

/**
 * Created by kallin on 2015-01-29.
 */
class ApplicationServer {

    public static void main(String[] args) {

        def game
        Thread.start {
            game = new Game()
            game.begin()
        }

        Thread.start {
            Server server = new Server(8080);
            WebSocketHandler wsHandler = new WebSocketHandler() {
                @Override
                public void configure(WebSocketServletFactory factory) {
                    factory.register(MyWebSocketHandler.class);
                }
            };
            server.setHandler(wsHandler);
            server.start();
            server.join();
        }

    }

}
