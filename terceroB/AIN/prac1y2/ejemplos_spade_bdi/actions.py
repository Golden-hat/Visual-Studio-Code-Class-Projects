import asyncio
import argparse

import agentspeak

import spade

from spade_bdi.bdi import BDIAgent


class MyCustomBDIAgent(BDIAgent):
    def add_custom_actions(self, actions):
        @actions.add_function(".my_function", (int,))
        def _my_function(x):
            return x * x

        @actions.add(".my_action", 1)
        def _my_action(agent, term, intention):
            arg = agentspeak.grounded(term.args[0], intention.scope)
            print(arg)
            yield


async def main():

	parser = argparse.ArgumentParser(description='spade bdi basic example')
	parser.add_argument('--login', type=str, default="basicagent", help='your UPV login.')
	parser.add_argument('--server', type=str, default="localhost", help='XMPP server address.')
	parser.add_argument('--password', type=str, default="bdipassword", help='XMPP password for the agent.')
	arguments = parser.parse_args()


	a = MyCustomBDIAgent("{}@{}".format(arguments.login, arguments.server), arguments.password, "actions.asl")

	await a.start()

	await asyncio.sleep(2)

	await a.stop()

if __name__ == "__main__":
        spade.run(main())