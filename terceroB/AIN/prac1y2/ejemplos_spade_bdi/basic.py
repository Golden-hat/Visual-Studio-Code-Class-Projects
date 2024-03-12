import asyncio
import argparse

import time

import spade

from spade_bdi.bdi import BDIAgent


async def main():

	parser = argparse.ArgumentParser(description='spade bdi basic example')
	parser.add_argument('--login', type=str, default="basicagent", help='your UPV login.')
	parser.add_argument('--server', type=str, default="localhost", help='XMPP server address.')
	parser.add_argument('--password', type=str, default="bdipassword", help='XMPP password for the agents.')
	args = parser.parse_args()

	a = BDIAgent("BasicAgent_{}@{}".format(args.login,args.server), args.password, "basic.asl")

	await a.start()

	await asyncio.sleep(1)

	a.bdi.set_belief("car", "azul", "big")
	a.bdi.print_beliefs()
	print("GETTING FIRST CAR BELIEF")
	print(a.bdi.get_belief("car"))
	a.bdi.print_beliefs()
	a.bdi.remove_belief("car", 'azul', "big")
	a.bdi.print_beliefs()
	print(a.bdi.get_beliefs())
	a.bdi.set_belief("car", 'amarillo')

	time.sleep(1)

	await a.stop()   

if __name__ == "__main__":
        spade.run(main())