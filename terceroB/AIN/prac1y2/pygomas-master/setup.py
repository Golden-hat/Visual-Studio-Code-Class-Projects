#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""The setup script."""

from setuptools import setup, find_packages


def parse_requirements(filename):
    """ load requirements from a pip requirements file """
    lineiter = (line.strip() for line in open(filename))
    return [line for line in lineiter if line and not line.startswith("#")]


with open('README.rst') as readme_file:
    readme = readme_file.read()

with open('HISTORY.rst') as history_file:
    history = history_file.read()

requirements = parse_requirements("requirements.txt")

setup_requirements = ['pytest-runner', ]

test_requirements = parse_requirements("requirements_dev.txt")

setup(
    author="Sergio Frayle Pérez",
    author_email='sfp932705@gmail.com',
    classifiers=[
        'Development Status :: 2 - Pre-Alpha',
        'Intended Audience :: Developers',
        'License :: OSI Approved :: GNU General Public License v3 (GPLv3)',
        'Natural Language :: English',
        'Programming Language :: Python :: 3',
        'Programming Language :: Python :: 3.6',
        'Programming Language :: Python :: 3.7',
    ],
    description="A Python 'capture the flag' Game Oriented Multiagent System.",
    install_requires=requirements,
    license="GNU General Public License v3",
    long_description=readme + '\n\n' + history,
    entry_points={
        'console_scripts': [
            'pygomas=pygomas.cli:cli'
        ]
    },
    include_package_data=True,
    keywords='pygomas',
    name='pygomas',
    packages=find_packages(include=['pygomas']),
    setup_requires=setup_requirements,
    test_suite='tests',
    tests_require=test_requirements,
    url='https://github.com/javipalanca/pygomas',
    version='0.5.1',
    zip_safe=False,
)
