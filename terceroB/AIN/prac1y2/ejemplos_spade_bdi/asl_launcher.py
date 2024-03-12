import asyncio
import argparse

import spade

from spade_bdi.bdi import BDIAgent
# python asl_launcher.py --login yassinet --server gtirouter.dsic.upv.es --asl factorial.asl

async def main():

	parser = argparse.ArgumentParser(description='spade bdi launcher example')
	parser.add_argument('--login', "-l", type=str, default="basicagent", help='your UPV login.')
	parser.add_argument('--server',"-s", type=str, default="localhost", help='XMPP server address.')
	parser.add_argument('--password',"-p", type=str, default="bdipassword", help='XMPP password for the agents.')
	parser.add_argument('--asl',"-a", type=str, default="default.asl", help='asl file with JASON code.')
	parser.add_argument('--time',"-t", type=int, default=1, help='duration time (in seconds) of the execution.')
	args = parser.parse_args()

	a = BDIAgent("Agent_{}@{}".format(args.login,args.server), args.password, args.asl)

	await a.start()

	#version web
	a.web.start(hostname="127.0.0.1",port="10000")

	await asyncio.sleep(args.time)

	await a.stop()

if __name__ == "__main__":
        spade.run(main())